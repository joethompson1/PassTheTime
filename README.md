<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="">
    <img src="https://github.com/joethompson1/joethompson/blob/master/src/assets/passTheTime.png" alt="Logo" width="180" height="180">
  </a>

  <h3 align="center">Pass The Time</h3>

  <p align="center">
    A fun android application made during lockdown, where the user has to try and stop a timer on exactly 0.0 seconds. Available on the Google Play Store.
    <br />
    <br />
    <a href="https://joethompson.co.uk/projects"><strong>- View Portfolio Overview</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

### Description:
This application was developed during covid as a fun little exercise for me to practice my mobile development experience, whilst at the same time being able to release an app onto the Google Play Store. This is because from a young age I have always wanted to release an app to the app store which is available to everyone (who has an android) around the world.

The premise of the game is very simple, the timer counts down from 10 and the user has to try and stop the timer on excatly 0.0 seconds. If they are successful then they will receive a small trophy at the top of the screen indicating how many times they have achieved this feat.

The app was developed in Android Studio using the programming languages Java and XML, and is sadly only available on the Google Play Store.




<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

The technologies I used to build this project are listed below:

* [![Android Studio][AndroidStudio]][AndroidStudio-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

If you wish to set up the project locally then follow these simple steps below.

### Prerequisites
If the following are already installed on your machine then you can skip this step.
If you don't have them installed then copy and paste the necessary lines below into the terminal.


#### Clone the repo
* Clone the datachain repository
   ```sh
   git clone https://github.com/joethompson1/Datachain.git
   ```



<br></br>


### Installation and Set Up of Front End

Follow the steps below to set up and start the project locally:


1. Go into dataChain/application-datachain/
   ```sh
   cd dataChain/application-datachain/
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Create new file called `config.js`

4. Enter your MongoDB API key in `config.js` remember to include `/datachain?retryWrites=true&w=majority` at the end of the URI
   ```js
   const mongoDBURI = 'ENTER YOUR API';
   // Should look something like below
   const mongoDBURI = 'mongodb+srv://<ACCOUNT NAME>:<PASSWORD>@<cluster>/datachain?retryWrites=true&w=majority';
   ```
5. Start the development server
   ```sh
   npm run devStart
   ```
6. Open the website locally in your browser
   ```
   http://localhost:3000/
   ```



<p align="right">(<a href="#readme-top">back to top</a>)</p>






<!-- LICENSE -->
## License

Distributed under the MIT License.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Joe Thompson 

Email: joe.cl.thompson@gmail.com

Github Link: [https://github.com/joethompson1/Datachain](https://github.com/joethompson1/Datachain)

<p align="right">(<a href="#readme-top">back to top</a>)</p>





<!-- MARKDOWN LINKS & IMAGES -->
[product-screenshot]: passTheTimeGameplay.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[Hyperledger]: https://img.shields.io/badge/Hyperledger_Fabric-FF0000?style=for-the-badge&logo=Hyperledger&logoColor=black
[Hyperledger-url]: https://www.hyperledger.org/use/fabric/
[AndroidStudio]: https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=Android_Studio
&logoColor=white
[AndroidStudio-url]: https://developer.android.com/studio
[NodeJS]: https://img.shields.io/badge/Node.JS-BAB86C?style=for-the-badge&logo=Node.js&logoColor=white
[NodeJS-url]: https://nodejs.org/en/
[MongoDB]: https://img.shields.io/badge/MongoDB-000000?style=for-the-badge&logo=MongoDB&logoColor=white
[MongoDB-url]: https://www.mongodb.com/
[NPM]: https://img.shields.io/badge/NPM-d90166?style=for-the-badge&logo=npm&logoColor=white
[NPM-url]: https://www.npmjs.com/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 