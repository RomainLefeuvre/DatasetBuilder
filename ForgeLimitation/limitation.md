Limitation C-6: forges do not provide appropriate tool-
ing for large scale mining
==
## Github :

Github offers one of the most comprehensive forge APIs with many
endpoints and features. Two APIs are proposed, a REST and a GraphQL API,
enabling an easy access to information on a given element of the model
used by Github (e.g., information on a repository, on a project's or a
user's output, etc.). Search endpoints are available and offer
Repository, Commit or Code searches on all Github.com. At first sight we
might assume that the APIs of Github would allow us to implement our
running request. We propose to split the query in two subquery that can
be converted to GitHub API requests :

1.  *Subquery 1 (SQ1) \"repositories of android applications\"* can be
    fulfilled using the code search REST API to retrieve all the file
    having AndroidManifest.xml as name and their corresponding
    repository.

        https://api.github.com/search/code?q=Q 
        //With the following query
        Q=filename:AndroidManifest.xml

2.  *Subquery 2 (SQ2) \"repositories which have a creation date not
    prior to 2015 and at least 1000 commits\"* can be handled by
    leveraging on the GraphQL API to get the creation date and the total
    number of commit of each repository return in 1. (NB: the REST API
    might also be used but will need two requests instead of one for the
    same result)

        query { 
         repository(owner: "OWNER", name: "REPOSITORY") {
                  createdAt
                  defaultBranchRef {
                    target {
                      ... on Commit {
                        history {
                          totalCount
                        }
                      }
                    }
                }
            }
        }

Thus we show that the Github API'S are expressive enough to allow us to
handle our query. However, there are many limitations that make this
task difficult to implement.

### Rate Limitation: 
The second limitation is the number of
API call and its impact in term of API rate limit. Indeed, GitHub has a
fixed rate limit for each user and we did not find any paid plan to
increase this rate limit.

-   The first subquery SQ1, between 3 and 9 million results are
    expected. Knowing that at most 100 results are returned per request,
    it would take between 30K and 90K queries. The rate limit is 30
    queries per minute for the search endpoint, consequently it would
    take between 17h and 50h to execute SQ1.

-   The second subquery SQ2, is then called on all the distinct
    Repository return by SQ1. As multiple AndroidManifest.xml can be
    contained in the same repository the number of repository returned
    will be less important than the number of file return by the api
    call. Nevertheless million of repository will be return. The second
    subquery SQ2, levarage on the graphql api that have a rate limit of
    5000 requests per hour which means that 4 million graphql API call
    will take more than 32 days.

All the previous query execution time estimations are based on the
assumption that rate limits are applicable in practice. However, in we
have not been able to use the entire quota. During our experiment we
faced, like many users[^1], \"secondary rate limitation\" that are
normally raised when an unappropriated use of the API is performed.
However, there is no apparent reason given that we respect the Github
best practices (e.g. waiting at least 1s between queries, respect rate
limitation, use appropriate headers \...) following [^2]. According to
the documentation, in this case, it is necessary to retry after the new
rate limit reset even if not all the quota has been consumed,
drastically reducing the number of allowed requests (1 request per
minute instead of 30 in the worst case). These problems make it almost
impossible to implement SQ2, which would take months to execute.
Finally, we observed that the *per_page* attribute setting
the number of entries per page returned and therefore per request does
not always behave as expected, as the API return in some cases less
elements than expected, requiring more requests to find all the entries.
[Operationalization limitation]{.underline} : The second limitation is
related to the difficulty of operating the CODE search endpoint on such
massive queries. The search endpoint only handles query that have less
than a thousand of element in response [^3]. Our query return millions
of result and is therefore not usable. A common tweak is to sample
massive query using available attribute filter (e.g a query that target
the Repository search endpoint can be sampled using repository creation
date), such treatment need complex heuristic which makes its
implementation very constraining. The only attribute that can be used to
sample SQ1 is the file size. In addition to the complexity of the
sampling heuristic, we observe that the Search endpoint is not
deterministic and not reliable. We reduce our query to
AndroidManifest.xml having a size in \[100000,110000\] bytes in order to
retrieve less than a thousand of results.

    curl -i \
      -H "Accept: application/vnd.github+json" \
      -H "Authorization: Bearer ghp_..."\
        'https://api.github.com/search/code?q=filename:AndroidManifest.xml+size:100000..110000&per_page=1'

It appears that the total count of results differ between call of the
same query. Leading to non-reproducible results.

    //Attempt#1 :
    "total_count":283
    //Attempt#2 :
    "total_count": 317,
    //Attempt#3 :
    "total_count": 327,

All these limitations make the use of this API difficult for large scale
mining purposes, both in terms of usability and the time needed to
perform the requests.

## Gitlab
is an open source forge and an end-to-end software development platform
allowing code version control, continuous integration or issue tracking.
The Gitlab API allow users to manipulate gitlab ressources
(projects,users ..) and perform CRUD operations. The Gitlab API can also
be used to automate Gitlab from external resources or within GitlabCI.
Similarly to GitHub, Gitlab offers a legacy REST Api as well as a
graphQl API. Search endpoints are available, allowing search for various
type of items such as commit or project in a Gitlab instance.

### Search Endpoints limitation
The Gitlab advanced search API [^4] allows premium user to search for files by name through the \"blob\" scope across the entire gitlab.com instance, according to the documentation.However, this feature is not available on gitlab.com, so that the first SBQ1 subquery is not supported by the Gitlab API[^5].

Although it is not possible to search directly through all projects in
the instance, it is possible to check for a given project if it contains
an \"AndroidManifest.xml\" file. :

-   The \"GET /projects/:id/repository/tree\" endpoint of the api can be
    used to list the contents of a repository tree. This requires a lot
    of pagination related queries. A trick is to limit the number of
    queries by interjecting an undocumented internal api, used in the
    gitlab web interface :  
    ```GET https://gitlab.com/gitlab-org/gitlab/-/files/master?format=json```.

-   The legacy search api can be used, as it only allows searching for
    files from their content, it is necessary to identify a sub string
    of the content to isolate this file ( eg \"\<manifest\")

There is no clear information about how much repo are in gitlab.com since it is not possible to know the results size of a query returning more than 10k records [^7]. However SWH crawl 3.9 M of repositories in gitlab, meaning that at least 3.9M of repositories are available.

We cannot get all the repositories containing a file named
\"AndroidManifest.xml\" at first and then filter those having a creation date not prior to 2015 and at least 1000 commits. We need to do the process in
the opposite order.

The gitlab api allow retrieving 100 records per page, more than 39000
API call are needed to get all the repository information. The rate
limit for this request is 2000 requests per minute, 19.5 minutes are
therefore needed. This query return information about repository,
including the creation date, allowing us to filter those created after 2015.  A second call is needed to get the total commit number per repository
[Todo]

[^1]: <https://github.com/orgs/community/discussions?discussions_q=secondary+rate+limit>

[^2]: <https://docs.github.com/en/rest/guides/best-practices-for-integrators?apiVersion=2022-11-28>

[^3]: https://docs.github.com/en/rest/search?apiVersion=2022-11-28

[^4]: <https://docs.gitlab.com/ee/api/search.html>

[^5]: <https://gitlab.com/gitlab-org/gitlab/-/issues/197231>

[^6]: https://forum.gitlab.com/t/advanced-search-not-searching-code-using-gold-trial/44149

[^7]: https://docs.gitlab.com/ee/api/index.html\#keyset-based-pagination