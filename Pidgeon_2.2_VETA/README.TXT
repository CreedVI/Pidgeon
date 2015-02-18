This is a BETA version that is still a work in progress. 

In this beta we are currently working on adding suppport for multiple tenses 
and possibly working a bit on other languages on the side...

To add a language go to /src/pidgeon/arrays.java and create a new section with the language name commented on the top.
pronoun array should be 1d and the actual verbs and conjugations should be a 2d array that follows this format:
{"To","verb","infinative","(Ir)Regular","first person singular","second person singular","third person singular","first person plural","second person plural",third person plural","third person formal"}
