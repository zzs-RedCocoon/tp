import pandas as pd
import numpy as np
from pandasql import sqldf
from string import printable # to test character entries

print("import success")

imdb_titles = pd.read_csv("movies.csv", low_memory=False)

imdb_titles = imdb_titles.drop(['titleType', 'originalTitle'], axis = 1)

imdb_titles.to_csv("imdb.csv", index=False)

print("done")

is_printable_string(string):
    for (char in string):
        if not char.isprintable():
            return false
    return true
