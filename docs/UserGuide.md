# MovieMate User Guide
MovieMate is a command-line app for managing your own list of movies that you’ve watched or planning to watch.
It allows you to store your ratings and reviews for different movies and give you a quick glance of your movie list.
You can also keep track of all the movies you plan to watch separately.
Moreover, it allows you to filter specific types of movies to help you search for the movie you want effectively.

- [Quick Start](#quick-start)
- [Features](#features)
  - [Viewing help: help](#viewing-help--help)
  - [Add a movie you've watched: watched](#add-a-movie-youve-watched--watched)
  - [Add a movie you want to watch: towatch](#add-a-movie-you-want-to-watch--towatch)

<hr>

# Quick Start 

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
> :exclamation: **Note about usage:**
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
Will print all the commands that the user can use.\
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

## Add a movie you've watched: `watched`
Adds a movie to your watched list.\
Format: `watched <Movie Name>`

> :exclamation: **Tip**: you may provide an incomplete title.
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
Adds an unwatched movie to your to-watch list.\
Format: `towatch <Movie Name>`
> :exclamation: **Note:** Functionality is similar to `watched` (see [above](#add-a-movie-youve-watched--watched)).

## list
Lists all the movies you have watched.\
Format: list\
Example:\
\>> list
1. \<Movie Name 1\>
2. \<Movie Name 2\>

## watchlist
Lists the movies you are planning to watch.\
Format: watchlist\
Example:\
\>> watchlist
1. \<Movie Name 1\>
2. \<Movie Name 2\>

### remove watched
Removes a movie from the list of watched movies.\
Format: remove watched \<Movie Index\>\
Examples:\
\>> list
1. Avengers: Endgame
2. La La Land
\
'''

'''
\
\>> remove watched 1\
\>> list
1. La La Land

### remove towatch
Removes a movie from the to-watch list.\
Format: remove towatch \<Movie Index\>\
Examples:\
\>> watchlist
1. Avengers: Endgame
2. La La Land
\
'''

'''
\
\>> remove towatch 1\
\>> list
1. La La Land

### seedetail
See the details of the movie as provided by the database. This does not include user-specific properties.\
Format: seedetail \<Movie Name\>\
Examples:\
\>> seedetail Avengers: Endgame\
\<length\>\
\<release date\>\
\<genre\>\
\<description of movie\>

### filter
Filters out and displays all movies in the watched and unwatched lists that fall under the specified genre.\
Format: filter \<Genre\>\
Examples:\
\>> filter comedy\
<Comedy Movie 1>
<Comedy Movie 2>

### addreview
Adds a review for a watched movie. The review will be done when the user types in /done.\
Format:\
\>> addreview \<Movie Index\> [enter]\
\>> \<your review\>\
\>> \<your review\>\
\>> /done\
Examples:\
\>> addreview 1\
\>> Such a thrilling movie to watch!\
\>> ...\
\>> ...\
\>> and that is the end of my review.\
\>> /done\
Review added!

### deletereview
Delete a review for a watched movie.\
Format: deletereview \<Movie Index\>\
Examples:\
\>> deletereview 1\
deleted Avengers: EndGame

### viewreview
Allows you to see your review of the watched movie.\
Format: viewreview <Movie Index>\
Examples:\
\>> viewreview 1\
Such a thrilling movie to watch!

### bye
Closes MovieMate.\
Format: bye\
Examples:\
\>> bye\
Hope you enjoy your experience with MovieMate and we will see you next time!

