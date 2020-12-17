<template>
  <div id="app">
    <div id="nav">
      <a class="logo-link" href="http://localhost:8081/">
        <img src="./assets/TEGram-logo.png" id="logo" alt="Logo" />
      </a>
      <div>
        <div class="nav-links">
          <div v-if="$store.state.token != ''">
            <router-link v-bind:to="{ name: 'home' }"
              >Home
              <img
                data-toggle="tooltip"
                title="Home"
                class="topImage"
                src="./assets/home.png"
                alt="home-link"
              /> </router-link
            >&nbsp; |&nbsp;
            <router-link v-bind:to="{ name: 'profile' }"
              >Profile
              <img
                data-toggle="tooltip"
                title="Profile"
                class="topImage"
                src="./assets/account.png"
                alt="user profile"
              /> </router-link
            >&nbsp; |&nbsp;
            <router-link v-bind:to="{ name: 'favorites' }"
              >Favorites
              <img
                data-toggle="tooltip"
                title="Favorites"
                class="topImage"
                src="./assets/heart.png"
                alt="favorite photos link"
              /> </router-link
            >&nbsp; |&nbsp;
            <router-link v-bind:to="{ name: 'upload' }"
              >Upload
              <img
                data-toggle="tooltip"
                title="Upload Image"
                class="topImage"
                src="./assets/upload-img.png"
                alt="upload-photo"
              /> </router-link
            >&nbsp; |&nbsp;

            <router-link v-bind:to="{ name: 'logout' }"
              >Logout
              <img
                data-toggle="tooltip"
                title="Logout"
                class="topImage"
                src="./assets/logout.png"
                alt="logout-photo"
              />
            </router-link>
          </div>
          <div v-else>
            <router-link v-bind:to="{ name: 'home' }"
              >Home
              <img
                data-toggle="tooltip"
                title="Home"
                class="topImage"
                src="./assets/home.png"
                alt="home-link" /></router-link
            >&nbsp; |&nbsp;
            <router-link v-bind:to="{ name: 'login' }"
              >Login
              <img
                data-toggle="tooltip"
                title="Login"
                class="topImage"
                src="./assets/login.png"
                alt="login-photo"
              />
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <router-view />
  </div>
</template>

<style>
@import "../style/style.css";
</style>