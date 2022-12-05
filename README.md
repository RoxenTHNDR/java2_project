# Java2 Reflections

## Intro
I really enjoyed this unit. It was mainly a refresh of the entire java 1 class.
The refresher was nice after being away from the language for a summer.
However, it seemed a lot simpler for the larger programs than it had in java 1.
I am hoping it was due to the fact that it is all something that I have already done.
This first assignment was creating an object/class, this upcoming one seems like it may be
a slight challenge. 

## Test Driven Development (TDD)
Over the past week we have focused on creating tests for our software. The way we did this 
was through a test class, that instantiated an object, and then would test the returns of all the 
public methods within said objects class. What this will allow us to do is make it easier to 
test specific methods in our code to check if when all goes well that we get what is expected,
or when an exception is thrown we get what we expected.

## Collections
This week we were mainly focusing on Collections. This mainly was a recap of some material we had done in
the previous JAVA course. However, it also added Sets and Maps. One of the exercises I found interesting
was taking an array list and making it so there was only one of each item within it. To do this in a very
simple manner, all we had to do was convert the list into a set and then back again, because a set only can
contain one of each element. Ex: List [1,1,2,2,3,3] -> Set [1,2,3] -> List [1,2,3]. I also found maps interesting
as they ran similar to a database table in that each entry has a key that it can be found by.

## Contributing to Open Source Projects
We had started our contributions to Hacktoberfest this week. Being an open source project for the entire class
over the month of October. I found this actually a bit challenging. Over the summer I had participated in up keep
and Updating a Discord Bot. However, we had basically done a shared repository (so merge-conflicts were a common
occurrence). At the point of writing this I am planning on getting help from Marc on posting my assignments to the open
source repository.

## Generics
This week we had talked about generics. Being able to create our own objects and inserting data types within said object.
Such as: `Example<String> exstr = new Example<>;`, creates a new object of type "Example" that contains Strings. Or
something similar: `Example<int> exint = new Example<>;` creates a new object of type "Example" that contains integers.
I could see myself using this in the case of the discord bot to make it easier to contain players.

## Lambda Functions
Lambda functions were a bit of a challenge for me up until this week. In java one I had realized that they may save time within writing
the actual code, however I felt as if they were less readable. Now that we took a deeper dive into how to write them and how they work 
with specific functional interfaces it makes much more sense to me. I also liked how in this week we took a more of deeper dive into reading 
documentation. Such as with the codewars assignment we worked on, where it challenged us to use a functional interface similar to that of a function
functional interface, but without using that specific interface. So that brought me to the documentation to figure out which interface uses the
`.applyAsDouble(T)` abstract method. Which lead me to the ToDoubleFunction Functional interface.

## GENERAL ETHICAL PRINCIPLES

### 1.1 Contribute to society and to human well-being

I promise to use my skills in programming and in computers to better the world surrounding me.
I promise to make sure that no matter what I do in the professional setting that it will benifet anyone who may use it.

### 1.2 Avoid harm

I promise to avoid harm at all costs with my skills. However, if any of my good intentions bring upon
unforeseen consequences that may cause harm, I promise to undo what I have done to the best of my ability.

### 1.3 Be honest and trustworthy.

I promise to be honest about my merits and skills. I promise to know and voice my limitations.

### 1.4 Be fair and take action not to discriminate.

I promise to not take my personal opinions into the work I do. I promise to be open with anyone and everyone.

### 1.5 Respect the work required to produce new ideas, inventions, creative works, and computing artifacts.

I promise to give credit where credit is due upon use in my code. I also promise that if in the case my code is used
elsewhere I will not argue the use of it if it is done in a reasonable manner.

### 1.6 Respect privacy.

I promise to only ask and/or use private information in a safe and ethical manner. I promise to make sure that while
this information is in my care it will be well guarded.

### 1.7 Honor confidentiality.

I promise to keep any nonpublic knowledge my clients are needed to entrust me with well secured. However, in the case 
of the information my clients bring to me are in fact in violation of law, I promise to bring said manner to the
respected authorities.