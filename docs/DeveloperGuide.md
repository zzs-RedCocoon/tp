# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


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

