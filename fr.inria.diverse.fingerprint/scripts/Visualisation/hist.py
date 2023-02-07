import json
import pandas as pd
from urllib.parse import urlparse
import click
@click.command()
@click.option('-r','--query-result-path', help='The json origin list produced by the query execution',required=True)
@click.option('-o','--originid-lastsnapid-originuri-path', help='OriginIdLastSnapIdOriginUri.json file path',required=True)
def run(query_result_path, originid_lastsnapid_originuri_path):
    """Simple script that produce an histogram of result forges"""
    with open(query_result_path, 'r') as f:
      result = json.load(f)
    
    lastSnapDf = pd.read_json(originid_lastsnapid_originuri_path)

    resDf = lastSnapDf.query('originId in @result')
    resDf['forge']=resDf.apply(lambda x: urlparse(x['originUri']).netloc, axis=1)
    res=resDf.forge.value_counts()
    fig=res.plot(kind='bar').figure
    fig.savefig('hist.png',bbox_inches='tight')
    print(res)
    
if __name__ == '__main__':
    run()
