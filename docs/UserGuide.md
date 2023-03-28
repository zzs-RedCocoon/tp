# MovieMate User Guide
MovieMate is a command-line app for managing your own list of movies that you’ve watched or planning to watch.
It allows you to store your ratings and reviews for different movies and give you a quick glance of your movie list.
You can also keep track of all the movies you plan to watch separately.
Moreover, it allows you to filter specific types of movies to help you search for the movie you want effectively.

- [Quick Start](#quick-start)
- [Features](#features)
  - [Viewing help: help](#viewing-help--help)
  - [Add a movie you have watched: watched](#add-a-movie-you-have-watched--watched)
  - [Add a movie you want to watch: towatch](#add-a-movie-you-want-to-watch--towatch)
    - [List out movies you have watched: `list`](#list-out-movies-you-have-watched-or-plan-to-watch--list--watchlist)
    - [Remove a listing from watched/to-watch list: `remove`](#remove-a-listing-from-either-list--remove)
  - [See a movie's details: `seedetail`](#see-a-movies-details--seedetail)
  - [Filter movies from your list by genres: `filter`](#filter-movies-from-your-list-by-genres--filter)
  - [Review a movie you have watched: `review`](#review-a-movie-you-have-watched--review)
    - [Delete a review: `deletereview`](#delete-a-review--deletereview)
    - [View a review: `viewreview`](#view-a-review--viewreview)
  - [Exit and save: `bye` or `exit`](#exit-and-save--bye-or-exit)
  

<hr>

# Quick Start {#start}

1. Ensure you have Java 11 or above installed in your Computer. 
2. Download the latest `moviemate.jar` from [here](https://github.com/AY2223S2-CS2113-W12-4/tp/releases).
3. Copy the file to the folder you want to use as the home folder for your MovieMate.
4. Open a command terminal, `cd` into the folder you put the jar file in,
and use the `java -jar moviemate.jar` command to run the application. 
5. You should then be able to use MovieMate through the command terminal.
6. Type the command in the command box and press Enter to execute it.
For example, you can start by typing the `help` command.
7. Refer to the [Features section](#features) below for details of each command.

<hr>

# Features
> ❗ **Note about usage:**
> 
> Words in `<angle brackets>` are parameters to be supplied by the user.\
> e.g. to add a watched movie with `watched <movie name>`,
> `<movie name>` is a parameter (spaces allowed), such as in `watched La La Land`.
> 
> Commands that do not take in parameters (such as `help`) will ignore any additional parameters.\
> e.g. inputting `help 123` will be interpreted as `help`.
> 
> In the below examples, text following `>>` indicates user input.

## Viewing help: `help`
Will print all the commands that the user can use.

Format: `help`

Example:
```
>> help
First time using MovieMate? Below is the quick guide for you to get to know about how to use the app ...
Add A Movie to the watched List: watched
Adds a movie to the list of watched movies.
If the item currently exists in the watchlist, it will be moved to the watched list.
...
```

## Add a movie you have watched: `watched`
Adds a movie to your watched list.

Format: `watched <movie name>`

> ❗ **Tip**: you may provide an incomplete title.
> You will then be prompted to pick among a few similar titles.
> 
> If the movie exists in your to-watch list, this will move the list to your watched list.

Examples:
```
>> watched La La

    1. La La Land
    2. La La Lol
Please enter the id of the movie you are looking for
The program will then proceed with adding the movie you chose, thanks!

>> 1

You have successfully added the movie into your list!
Here is the movie detail
    La La Land
Feel free to continue with other features
```

## Add a movie you want to watch: `towatch`
Adds an unwatched movie to your to-watch list.

Format: `towatch <movie name>`
> ❗ **Note:** Functionality is similar to [`watched`](#add-a-movie-youve-watched--watched).

### List out movies you have watched or plan to watch: `list`/`watchlist`
Show a list of all the movies you have watched.

Format:\
`list` for movies you have watched.\
`watchlist` for movies you plan to watch.

Example:
```
>> list
1. Movie Name 1
2. Movie Name 2
```

### Remove a listing from either list: `remove`
Removes a movie from either list of movies.
You will first choose which list to remove from, and then separately provide the movie number to delete.

Format:\
`remove watched <movie_index>` to remove a movie from your watchlist.\
`remove towatch <movie_index>` to remove a movie from your to-watch list.

Examples:
```
>> remove watched
1. Avengers: Endgame
2. La La Land

>> 1

>> list
1. La La Land
```
> ❗ **Coming soon:** we will add better feedback for user after removal.

## See a movie's details: `seedetail`
See the details of the movie as provided by the database, by index or movie name.\
This does not include user-specific properties, like reviews.

Format: `seedetail [watched/ towatch]`

Examples:
```
>> seedetail watched
Below are the movies from your watched list
1. La La LAnd
2. Captain Americ
Please enter the index of the movie you would like to see the detail of it:
>> 1
Title: La La Land
Year: 2018
Genre: Love
...
```

Format: `seedetail movie`

Examples:
```
>> seedetail movie
Please enter the name of the movie you would like to see the detail of it:
>> La La Land
Below are the relevant movies found from the movie name entered
1. La La Land
2. La La Land the miracle
...
Please enter the index of the movie that you would like to view the detail of it!
>> 1
Title: La La Land
Year: 2018
Genre: Love
...
```
> ❗ **Coming soon:** we will improve the way to search movie by titles.

## Filter movies from your list by genres: `filter`
Filters out and displays all movies in the watched and unwatched lists that fall under the specified genre.

Format: filter <genre>

Examples:
```
>> filter comedy

Watched
1. Bee Movie

To Watch
1. Shrek
2. Johnny English
```

> ❗ **Coming soon:** we will add a way to list/search genres, in case the user makes a typo.

## Review a movie you have watched: `review`
Adds a review for a watched movie. The user is first prompted for a text review, which ends once the user
enters a blank line. The user is then asked for a numerical rating (out of 5).

Format: `review <movie_index>`

Examples:
```
>> review 1

Write your review. Use as many lines as you need. To end, simply input a blank line.
...
```

Reviews can also be deleted and viewed with the following commands:

### Delete a review: `deletereview`
Delete a review for a watched movie.
Format: `deletereview <movie_index>`

### View a review: `viewreview`
Allows you to see your review of a movie.
Format: `viewreview <movie_index>`

## Exit and save: `bye` or `exit`
Closes MovieMate and saves your data.
> ❗ Make sure to use this command instead of closing the window.
> This will save the data. Closing the window in other ways will not save the data.
 
Format: `bye` or `exit`

