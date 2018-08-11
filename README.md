# CheapTrip - Sample Android App

This project was created to help people understand the latest best practices about Android app development.

I know there are a lot of things to learn and most of the time is really overwhelming but I 
will try my best to help you as much as I can.

![screenshot_1533943609](https://user-images.githubusercontent.com/35080524/43985184-3fb1337c-9cba-11e8-922c-e0f238832e27.png) ![screenshot_1533943612](https://user-images.githubusercontent.com/35080524/43985185-3fc9a132-9cba-11e8-9745-e93ead750800.png)

## Project X-Ray

Throughout this project's development I will be updating this section with a detailed explanation about the "hard to understand" 
components implemented here such as NetworkBoundResource class, repository pattern, MVVM, Dagger...

Also, I will explain how I started and what is the "path" I've been following along in this project.

One of the main issues I had whenever I started studying a new sample project was that everything was already done. 

Even though I understood the concepts I was trying to learn I still didn't have any clue on how to apply it in my projects 
from scratch. 

Because of that, I know how important it is to not only understand the concept itself but to learn which order it was built. 

Of course, there is no right way or right path but a little help in the beginning will help you fully understand 
the subject and make you adapt yourself better to any project or problem you are facing.

Besides that, I will be recommending a lot of external resources where you can learn and consolidate your 
knowledge from another perspective instead of keeping hunting out there for good resources to learn.

## How to Build

For this project I wanted to create something related to travel. Unfortunately, I couldn't find any free and fast to
implement travel API (maybe I didn't search enough) to use in this project. For this reason I decided to create my own API
fed by dummy data to mock API calls.

In order to build this project you will need to download the Django project and run it. Step by step [here](#runninglocalserver).

If you already downloaded this project and ran the Django local server you need to set up the base url correctly to start fetching data
from API. The retrofit service is being created inside AppModule.kt and the base url parameter on "Retrofit.Builder()" is what you
need to change. This base url should be your local network IP.

On MAC you can find on: System Preferences > Network

<img width="320" alt="screen shot 2018-08-10 at 5 27 18 pm" src="https://user-images.githubusercontent.com/35080524/43986214-fafd9aa0-9cc2-11e8-97bb-35d0c57e2fb4.png">

**DO NOT** build this project on android API 28 (Android Pie). Due to security reasons it won't let you fetch information from your
local server that will be under "http" protocol. If you still want to do this way there are couple workaround that a simple google search
will do the job.

## <a name="runninglocalserver">Running Django Local Server</a>

If you already know how to setup a Django project you need to run the server like this:

`python manage.py runserver 0.0.0.0:8000`

It will pretty much allow any hardware (android emulator, physical devices) to access your local server without further problems.

**STEP BY STEP ON HOW TO SETUP DJANGO PROJECT COMING SOON**

## How to Contribute

In order to contribute to this project you need to:

1. Fork this repository
2. Make changes on your forked project
3. Pull request
4. Wait for approval

Everyone is more than welcome to contribute and implement your own ideas in this project.

If you want to help but have no idea what to do you can always check [What Next](#runninglocalserver) section
things that haven't been implemented yet.

## <a name="whatnext">What Next (Android)</a>

|   To Do       |   Difficulty  |
| ------------- |:-------------:|
| Tweak Flight List Item UI/UX     | Easy |
| Progress Bar (Synced with Resource Object) | Easy |
| Login/Register Activity | Easy |
| Set Empty Recycler View State | Easy |
| Fix date time format | Easy |
| Add Tests For Initial Commit  | Hard |
| Flight Detail Activity | Hard |

## What Next (Django)

|   To Do       |   Difficulty  |
| ------------- |:-------------:|
| Dynamic Flight List | Easy |
| Django Authentication | Easy |
| Flight Information (Seats left, Airplane Type...) | Easy |
| Dynamic Search Endpoints     | Hard |

