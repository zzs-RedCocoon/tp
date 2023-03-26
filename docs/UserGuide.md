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
Format:\
watched \<Movie Name\>\
\<Movie Index\>\
Examples:\
\>> watched La La
1. La La Land
2. La La Lol

Please enter the id of the movie you are looking for\
The program will then proceed with adding the movie you chose, thanks!

\>> 1\
You have successfully added the movie into your list!\
Here is the movie detail\
La La Land\
Feel free to continue with other features

\>> list
1. La La Land

### towatch
Adds an unwatched movie to your to-watch list.\
Format:\
towatch \<Movie Name\>\
\<Movie Index\>\
Examples:\
\>> towatch La La
1. La La Land
2. La La Lol

Please enter the id of the movie you are looking for\
The program will then proceed with adding the movie you chose, thanks!

\>> 1\
You have successfully added the movie into your list!\
Here is the movie detail\
La La Land\
Feel free to continue with other features

\>> watchlist
1. La La Land

#### list
Lists all the movies you have watched.\
Format: list\
Example:\
\>> list
1. \<Movie 1\>
2. \<Movie 2\>

### watchlist
Lists the movies you are planning to watch.\
Format: watchlist\
Example:\
\>> watchlist
1. \<Movie 1\>
2. \<Movie 2\>

### remove watched
Removes a movie from the list of watched movies.\
Format: remove watched \<Movie Index\>\
Examples:\
\>> list
1. Avengers: Endgame
2. La La Land

\>> remove watched 1\
Ok! Movie removed from your list.\
\>> list
1. La La Land

### remove towatch
Removes a movie from the to-watch list.\
Format: remove towatch \<Movie Index\>\
Examples:\
\>> watchlist
1. Avengers: Endgame
2. La La Land

\>> remove towatch 1\
Ok! Movie removed from your list.\
\>> watchlist
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
In WatchedList:
1. <Comedy Movie 1>

In ToWatchList:
1. <Comedy Movie 2>

### addreview
Adds a review for a watched movie. The text review will be done when the user enters a blank line.\
When prompted for a numerical rating, please give a number from 0 to 5.\
Format:\
\>> addreview \<Movie Index\> [enter]\
\>> \<text review\>\
\>> \<text review\>\
\>> [enter]\
...\
\>> \<numerical review\>\
Examples:\
\>> addreview 1\
\>> Such a thrilling movie to watch!\
\>> ...\
\>> ...\
\>> and that is the end of my review.\
\>> [enter]\
Text review added.\
Please rate the movie [0 to 5]:\
\>> 5\
Star review added.

### deletereview
Delete a review for a watched movie.\
Format: deletereview \<Movie Index\>\
Examples:\
\>> deletereview 1\
Successfully deleted the review of movie 1.

### viewreview
Allows you to see your review of the watched movie.\
Format: viewreview \<Movie Index\>\
Examples:\
\>> viewreview 1\
Review: Such a thrilling movie to watch!(5/5 stars)

### bye
Closes MovieMate.\
Format: bye\
Examples:\
\>> bye\
Hope you enjoy your experience with MovieMate and we will see you next time!

