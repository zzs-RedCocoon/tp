# MovieMate User Guide
MovieMate is a command-line app for managing your own list of movies that you’ve watched or planning to watch. It allows you to store your ratings and reviews for different movies and give you a quick glance of your movie list. You can also keep track of all the movies you plan to watch separately. Moreover, it allows you to filter specific types of movies to help you search for the movie you want effectively.

## Features
### help
Will print all the commands that the user can use.\
Format: help\
\>> help\
First time using MovieMate? Below is the quick guide for you to get to know about how to use the app ...\
Add A Movie to the watched List: watched\
Adds a movie to the list of watched movies.\
If the item currently exists in the watchlist, it will be moved to the watched list.

### watched
Adds a movie to your watched list.\
Format: watched \<Movie Name\>\
Examples:\
\>> list\
Titanic\
\>> watched Avengers: Endgame\
\>> watched La La Land\
 \
\>> list\
Titanic\
Avengers: Endgame\
La La Land

### towatch
Adds an unwatched movie to your to-watch list.\
Format: towatch \<Movie Name\>\
Examples:\
\>> watchlist\
Titanic\
\>> towatch Avengers: Endgame\
\>> towatch La La Land\
 \
\>> watchlist\
Titanic\
Avengers Endgame\
La La Land

#### list
Lists all the movies you have watched.\
Format: list\
Example:\
\>> list\
\1. \<Movie Name 1\>\
\2. \<Movie Name 2\>

### watchlist
Lists the movies you are planning to watch.\
Format: watchlist\
Example:\
\>> watchlist\
\1. \<Movie Name 1\>\
\2. \<Movie Name 2\>

### remove watched
Removes a movie from the list of watched movies.\
Format: remove watched \<Movie Index\>\
Examples:\
\>> list\
1\. Avengers: Endgame\
2\. La La Land\
 \
\>> remove watched 1\
\>> list\
1\. La La Land

### remove towatch
Removes a movie from the to-watch list.\
Format: remove towatch \<Movie Index\>\
Examples:\
\>> watchlist\
1\. Avengers: Endgame\
2\. La La Land
 \
\>> remove towatch 1\
\>> list\
1\. La La Land

### seedetail
See the details of the movie as provided by the database. This does not include user-specific properties.\
Format: seedetail \<Movie Index\>\
Examples:\
\>> seedetail 1\
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

