# TalaApp

Using MVVM and clean Architechture.

I split the lyers into 

DATA
DOMAIN
PRESENTATION
UI

And made appropaite mappers for each stage, this is to ensure that even if we want to change the databse we can do so without affecting other layers

Some tests were failing from some Hilt Modules because of initialization chanllenges
