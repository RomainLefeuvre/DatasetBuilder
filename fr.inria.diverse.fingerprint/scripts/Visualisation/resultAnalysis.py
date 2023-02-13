### SCRIPT GENERATED USING 

import sys
import json
import matplotlib.pyplot as plt
import numpy as np
import click
import pyspark
from pyspark.sql import SparkSession
from pyspark.sql.functions import *
from pyspark.sql.types import *

spark = SparkSession.builder.appName("JoinData").config("spark.executor.memory", "50g").config("spark.driver.memory", "50g").getOrCreate()

@click.command()
@click.argument("origin_json")
@click.argument("origin_url_parquet")
def join_data(origin_json, origin_url_parquet):
    print(origin_json)
    print(origin_url_parquet)
    
    # Load the parquet file
    origin_url_df = spark.read.parquet(origin_url_parquet)
    
    # Load the json array
    with open(origin_json) as f:
        origin_ids = json.load(f)

    # Convert the json array to a Spark DataFrame
    origin_ids_df = spark.createDataFrame(origin_ids, LongType()).toDF("originId")

    # Join the two DataFrames on the originId column
    joined_df = origin_url_df.join(origin_ids_df, origin_url_df.originId == origin_ids_df.originId, "inner")

    # Extract the domain from the originUrl column
    joined_df = joined_df.withColumn("domain", regexp_extract(joined_df.originUrl, "https?://(.+?)[./]", 1))

    # Group by the domain and count the number of occurrences
    result = joined_df.groupBy("domain").agg(count("*").alias("count"))

    result.show()
     # Convert the result to a Pandas DataFrame
    result_pandas = result.toPandas()

    # Plot a bar chart of the count values
    plt.bar(result_pandas["domain"], result_pandas["count"])
    plt.xlabel("Forge")
    plt.xticks(rotation=90)
    plt.ylabel("Count")
    plt.title("Bar Chart of Domain Counts")
    plt.show()

if __name__ == "__main__":
    join_data()

