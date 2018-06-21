# aleatory-service-draft
Project draft for Spring Boot, which uses the math libraries Apache Commons Math4 version 4.0-SNAPSHOT, RNG version 1.1-SNAPSHOT. JUnit and Mockito Core for the Test-Driven Development.

aleatory-service-draft is a web service application which provides pseudo random numbers through GET requests, developed according to the Test-Driven Development dictates.

The web application uses the snapshots of the Apache Commons RNG and Math4 libraries.
The root address, “/”, returns a number generated via UncorrelatedRandomVectorGenerator, thanks to the method nextVector(), then choose an element of the carrier through the class java.security.SecureRandom.
The address “/raw”, directly return a number generated via UniformRandomProvider, thanks to the method nextDouble() which generates a value between zero and one.
The address “/vector”, return a vector of two hundred fifty six elements via UncorrelatedRandomVectorGenerator, directly thanks to the method nextVector().

As always, once you have downloaded the generic project template generated on the Spring Initializr website, with the specific requests that can be deduced from the pom file, you can import it into your preferred IDE and add the source files found here. Please give attention to the correct Java language package system. Thank you.
