**Difference between Inheritence vs Composition**
--------------------------------------------------

Inheritence lead to tight coupling of the code where composition lead to decoupling of the code

By Interitence child class can have access to parent class where as in composition access to 
parent class method is not possible directly unless some deligacy is not followed.

Interitence is is-a relation ship but composition is has-a relation ship.

Inheritence is tied to its parent class where as Composition is not tied to its parent class.

Composition is needed when you know that parent class can be changed in future by which there 
won't be any impact on child behaviour. 

Logical Reason - 

when you need to create classes and structures then you need to understand the relation ship before
you go ahead with classes creation.
1. if you know any subclass is going to type of it then it should be is-a relation then inheritence
2. if you know some thing is going to be contained in the child class then it should be composition.

