<template>
  <div class="background">
    <div class="home">
      <div class="header">
        <!-- Logo -->
        <router-link v-bind:to="{ name: 'home' }">
          <img id="logo" src="../assets/TeGram-logo.png" alt="TE-Gram Logo" />
        </router-link>
        <!-- End Logo -->

        <!-- Navbar icons -->
        <nav>
          <ul>
            <li>
                <router-link v-bind:to="{name: 'home'}">
                  <img class="topImage" src="../assets/home.png" alt="home-link" width="35" height="35" />
                </router-link>
            </li>
            <li>
              <router-link v-bind:to="{name: 'favorites'}">
                <img class="topImage" src="../assets/heart.png" alt="favorite photos link" width="35" height="35" />
              </router-link>
            </li>
            <li>
              <router-link v-bind:to="{name: 'profile'}">
                <img class="topImage" src="../assets/account.png" alt="user profile" width="35" height="35" />
              </router-link>
            </li>
            <li>
              <router-link v-bind:to="{name: 'upload' }">
                <img class="topImage" src="../assets/upload-img.png" alt="upload-photo" width="35" height="35"/>
              </router-link>
            </li>
            <li>
              <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
              </router-link>
            </li>
          </ul>
        </nav>
        <!-- End nav -->
      </div>
    </div>
  </div>
</template>


<style>
.backgound {
  background-color: #f4f4f4;
}
.home {
  display: grid;
  grid-template-columns: 1fr 2fr 1fr;
  grid-template-areas:
    "header header header"
    ".   main   ."
    ".  footer .";
  height: 100vh;
  width: 100vw;
  grid-gap: 12px;
  padding-top: 80px;
}
.header {
  grid-area: header;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "header-logo header-search header-nav";
  margin-bottom: 20px;
  opacity: 0.7;
  position:fixed;
  left:0;
  top:0;
  width:100vw;
  z-index:200;
  height:110px;
  background-color: white;
  border-bottom: .5px solid gray;
}
.header #logo {
  grid-area: header-logo;
  height: 150px;
  width: 150px;
}
.header #searchUsers {
  grid-area: header-search;
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin-left: 75px;
  margin-top: 62px;
  height: 20px;
  width: 200px;
  border-radius: 5px #00adee;
}
nav {
  grid-area: header-nav;
  display: flex;
  justify-content: center;
  flex-direction: column;
}
nav ul {
  display: flex;
  justify-content: space-evenly;
}
nav ul li {
  list-style: none;
}
footer {
  grid-area: footer;
  margin-bottom: 20px;
}
.modal {
  width: 500px;
  margin: 0px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 8px 3px;
  transition: all 0.2s ease-in;
  font-family: Arial, Helvetica, sans-serif;
}
.fadeIn-enter {
  opacity: 0;
}
.fadeIn-leave-active {
  opacity: 0;
  transition: all 0.2s step-end;
}
.fadeIn-enter .modal,
.fadeIn-leave-active .modal {
  transform: scale(1.1);
}
.uploadBtn {
  height: 87px;
  width: 87px;
  margin: 10px;
  font-size: 1.2rem;
  background-color: whitesmoke;
  border-radius: 50%;
  position: fixed;
  right: 10px;
  bottom: -4px;
  box-shadow: 0 1px 3px 2px;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: #00000094;
  z-index: 999;
  transition: opacity 0.2s ease;
}
#upload-photo {
  text-align: center;
}
.upload-photo-btn {
  width: 150px;
  height: 40px;
  border: none;
  outline: none;
  box-shadow: -4px 4px 5px 0 #feb361;
  color: #fff;
  font-size: 14px;
  text-shadow: 0 1px rgba(0, 0, 0, 0.4);
  background-color: #00adee;
  border-radius: 3px;
  font-weight: 700;
}
.submitBtn:hover {
  background-color: #0b7ca5;
  cursor: pointer;
}
.submitBtn:active {
  margin-left: -4px;
  margin-bottom: -4px;
  padding-top: 2px;
  box-shadow: none;
}
.feed {
  grid-area: main;
  margin-top: 100px;
}
.selected {
  padding: 5px;
  box-shadow: 0 1px 3px 2px;
  border-radius: 25%;
}
</style>