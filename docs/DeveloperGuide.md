# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}


<!-- Zhan hong working on this section-->
# Review Feature
**API:** [Review.java](https://github.com/AY2223S2-CS2113-W12-4/tp/blob/master/src/main/java/Review.java)

Here's a partial class diagram of the `Review` component:

![](/PUMLFiles/Review/review1.png)

The `Review` component contains both a descriptive review `reviewText`,
and a numerical review `reviewStars` (0 to 5 inclusive). Both are modified through the
`setReview()` method.

`Review` implements [`Comparable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html), and is compared
through simply comparing `reviewStars`.

How the `Review` component works:

**Step 1.** `setReview()` is called, which creates a [`Scanner`](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)
to read user input.

![](/PUMLFiles/Review/review2.png)

**Step 2.** User input is read (multiple lines) until a blank line is found.
Then, `reviewText` is updated with the text input.

**Step 3.** Next, user is prompted for a numerical input (with input validation).
This value is updated into `reviewStars`.

**Step 4.** Finally, `Scanner` is closed and `Review` is done setting.

# Movie List Feature
**API:** [Movie.java](https://github.com/AY2223S2-CS2113-W12-4/tp/blob/master/src/main/java/MovieList.java)

Here's a partial class diagram of the `MovieList` component:

![](/PUMLFiles/MovieList/movielist1.png)

The `MovieList` component has two inherited classes `ToWatchList` and `WatchedList`. It contains a public method `movieList` for creating an empty movie list,
which also has a overloaded constructor for creating a movie list with an existing list.
In addition, `MovieList` contains a public method `add`, which will search for relevant movies in the database
and help user to add a new movie to the movie list. It also contains a public method `filter`, 
which will filter the movies with certain genre and display it to the user. The public method `remove`, will remove a movie from the list, 
and this will be implemented soon. Other methods such as `getMovie()` and `toString()` are also included in `MovieList`. 


How the `MovieList.add(String inputTitle)` component works:

![](/PUMLFiles/MovieList/movielist2.png)

**Step 1.** `add(String inputTitle)` is called, which continues to call `find()` in `MovieDatabase` to search for the relevant movies.
It will then display at most five movies that matches the `inputTitle`.

**Step 2.** Next, user is prompted for a numerical input (with input validation).
This value indicates the movie index chosen by the user from the list.

**Step 3.** Next, `createMovie` is called to create a new `Movie` object according to the index and add the movie to the movie list.

**Step 4.** The `add(String inputTitle)` will show feedback message to the user.

**Step 5.** The `add(String inputTitle)` has finished everything and returned.

How the `MovieList.filter(String genre)` component works:

**Step 1.** `filter(String genre)` is called. `getClass()` and `getName()` are then called to get the relevant list's class and name.
For example, if `filter` is done on the WatchedList, "In WatchedList:" is displayed.

**Step 2.** An integer i is initialized with a value of 1.

**Step 3.** Iterate through the MovieList. For each movie, `getGenres()` is called to obtain its array of genres, which is checked
to see if it contains the input genre. If true, a description of the movie will be displayed on a new line and i is
incremented. If false, nothing will be displayed.

**Step 5.** After the entire iteration is complete, if i == 1, it means no movies were found containing the input genre in their
genre array. Feedback message displayed accordingly and `filter` returns.
