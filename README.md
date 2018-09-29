# CheapTrip - Sample Android App

This project was created to help people understand the latest best practices about Android app development.

I know there are a lot of things to learn and most of the time is really overwhelming but I 
will try my best to help you as much as I can.

![screenshot_1533943609](https://user-images.githubusercontent.com/35080524/43985184-3fb1337c-9cba-11e8-922c-e0f238832e27.png) ![screenshot_1533943612](https://user-images.githubusercontent.com/35080524/43985185-3fc9a132-9cba-11e8-9745-e93ead750800.png)

## Project X-Ray

Throughout this project's development I will be updating the wiki with tons of specific information about this project.

In the future I plan to have one page explaining the implementation of each component in my app.

For example, it will have a page for Dagger2 where I will be covering the basics and how I implemented it in this app.

Also, it will contain a lot of good external resources where you can learn more about that subject and consolidate your knowledge from a different perspective.

Click [here](https://github.com/rickpms/CheapTrip/wiki) to access.

## How to Build

For this project I wanted to create something related to travel. Unfortunately, I couldn't find any free and fast to
implement travel API (maybe I didn't search enough) to use in this project. For this reason I decided to create my own API
fed by dummy data to mock API calls.

In order to build this project you will need to [download the Django project](https://github.com/rickpms/CheapTripDjango) and run it. Step by step [here](#runninglocalserver).

If you already downloaded this project and ran the Django local server you need to set up the base url correctly to start fetching data
from API. The retrofit service is being created inside AppModule.kt and the base url parameter on "Retrofit.Builder()" is what you
need to change. This base url should be your local network IP.

On MAC you can find on: System Preferences > Network

<img width="320" alt="screen shot 2018-08-10 at 5 27 18 pm" src="https://user-images.githubusercontent.com/35080524/43986214-fafd9aa0-9cc2-11e8-97bb-35d0c57e2fb4.png">

**DO NOT** build this project on android API 28 (Android Pie). Due to security reasons it won't let you fetch information from your
local server that will be under "http" protocol. If you still want to do this way there are couple workaround that a simple google search
will do the job.

*App created on Android Studio 3.2 beta 5*

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
| Pull to refresh | Easy |
| Login/Register Activity | Easy |
| Set Empty Recycler View State | Easy |
| Fix date time format | Easy |
| Add Tests For Initial Commit  | Hard |
| Integrate Paging Library  | Hard |
| Flight Detail Activity | Hard |

## What Next (Django)

|   To Do       |   Difficulty  |
| ------------- |:-------------:|
| Dynamic Flight List | Easy |
| Django Authentication | Easy |
| Flight Information (Seats left, Airplane Type...) | Easy |
| Dynamic Search Endpoints     | Hard |

## Contact Me

 * **Email** - ricksofteng@gmail.com
 * **Medium** - https://medium.com/@rickprata

## License
```
MIT License

Copyright (c) 2018 Rick Prata

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

