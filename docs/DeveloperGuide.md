---
layout: page
title: Developer Guide
---
* Table of Contents
  {:toc}

# Developer Guide: Movie Mate

## Acknowledgements

Many thanks to Akshay, Ngiap Hin, and [AddressBook3](https://github.com/se-edu/addressbook-level3) for the help.

## Setting Up

Setup guide for developing MovieMate can be found [here](SetupGuide.md).

## Design & implementation

### Architecture

todo: architechture image here.

The **Architecture Diagram** above gives a high-level design of MovieMate.

Given below is a quick overview of main components and how they interact with each other.

#### Main Components

TODO: Fix this link;

The main class is found in [`MovieMate`](https://github.com/AY2223S2-CS2113-W12-4/tp/blob/master/src/main/java/seedu/moviemate/MovieMate.java). It is responsible for managing
calls to the other classes and establishing required files.

`MovieMate` makes use of some core general components: (LINKS TODO)
- [`UI`](#)
- [`Storage`](#)
- [`Parser`](#)
- [`Command`](#)

Finally, all the movie-related classes are packaged in [`Movie`](#).

## Product scope
### Target user profile
Movie Lovers, people who love to watch movies and need an app to keep track of the movies they have watched and want to watch in the future.

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

| Version | As a ... | I want to ...                               | So that I can ...                                                      |
|---------|----------|---------------------------------------------|------------------------------------------------------------------------|
| v1.0    |new user| see usage instructions                      | refer to them when I forget how to use the application                 |
| v1.0    |user| add a watched/ to-watch movie by short name | add a watched/to-watch movie without having to type out the whole name |
| v1.0    |user| add a watched/ to-watch movie               | keep track of the movie I have watched/ want to watch                  |
| v1.0    |user| delete a watched/ to-watch movie            | keep track of the movie I have watched/ want to watch                  |
| v1.0    |user| store my movie lists on my laptop           | easily find the information of my movie list                           |
| v2.0    |user| add a review to my watched movie            | keep track of my opinion about the movie                               |
| v2.0    |user| delete a review to my watched movie         | keep track of my opinion about the movie                               |
| v2.0    |user| see detail of a movie                       | know whether I have watched the movie or I would like to watch it      |
| v2.0    |user| get some random movie of certain genre      | get some inspiration of which movie to watch                           |


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

How the `MovieList.remove()` component works:

![](/PUMLFiles/MovieList/movielist3.png)

**Step 1.** `remove` command is entered, which continues to call `showListMessage()` in `Ui` to 
show the user the movies in the list.
It will then display all movies from `watched list` or `to-watch list`, allowing the user to easily pick the movie for deletion.

**Step 2.** Next, user is prompted for a numerical input (with input validation).
This value indicates the movie index chosen by the user from the list.

**Step 3.** Next, `remove()` is called to remove a  `Movie` object according to the index and delete the movie to the movie list.

**Step 4.** The function will call `showDeleteMessage` from `Ui`, which will show feedback message to the user.

**Step 5.** The `remove` command has finished everything and ended.

How the `MovieList seedetail` component works:

![](/PUMLFiles/MovieList/movielist4.png)

**Step 1.** `seedetail` command is entered, which continues to call `showListMessage()` in `Ui` to
show the user the movies in the list.
It will then display all movies from `watched list` or `to-watch list`, 
allowing the user to easily pick the movie for viewing detail.

**Step 2.** Next, user is prompted for a numerical input (with input validation).
This value indicates the movie index chosen by the user from the list.

**Step 3.** Next, `getMovieDetail()` is called to get the detail of a  `Movie` object 
according to the index and return the detail of the specified movie.

**Step 4.** The function will call `showDetailMessage` from `Ui`, which will show feedback message to the user.

**Step 5.** The `seedetail` command has finished everything and ended.

How the `MovieList.filter(String genre)` component works:

**Step 1.** `filter(String genre)` is called. `getClass()` and `getName()` are then called to get the relevant list's class and name.
For example, if `filter` is done on the WatchedList, "In WatchedList:" is displayed.

**Step 2.** An integer i is initialized with a value of 1.

**Step 3.** Iterate through the MovieList. For each movie, `getGenres()` is called to obtain its array of genres, which is checked
to see if it contains the input genre. If true, a description of the movie will be displayed on a new line and i is
incremented. If false, nothing will be displayed.

**Step 5.** After the entire iteration is complete, if i == 1, it means no movies were found containing the input genre in their
genre array. Feedback message displayed accordingly and `filter` returns.
