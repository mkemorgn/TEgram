<template>
  <div id="app">
    <div id="nav">
      <a class="logo-link" href="http://localhost:8081/">
        <img
          src="./assets/TE_Mark_Website2020_v3-01.png"
          id="logo"
          alt="Logo"
        />
        TE Gram
      </a>
      <div>
        <div class="nav-links">
          <div v-if="$store.state.token != ''">
            <router-link
              v-bind:to="{ name: 'home' }"
              data-toggle="tooltip"
              title="Home"
            >
              <img
                class="topImage"
                src="./assets/home.png"
                alt="home-link"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
            <router-link
              v-bind:to="{ name: 'profile' }"
              data-toggle="tooltip"
              title="Profile"
            >
              <img
                class="topImage"
                src="./assets/account.png"
                alt="user profile"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
            <router-link
              v-bind:to="{ name: 'favorites' }"
              data-toggle="tooltip"
              title="Favorites"
            >
              <img
                class="topImage"
                src="./assets/heart.png"
                alt="favorite photos link"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
            <router-link
              v-bind:to="{ name: 'upload' }"
              data-toggle="tooltip"
              title="Upload Image"
            >
              <img
                class="topImage"
                src="./assets/upload-img.png"
                alt="upload-photo"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;

            <router-link
              v-bind:to="{ name: 'logout' }"
              data-toggle="tooltip"
              title="Logout"
            >
              <img
                class="topImage"
                src="./assets/logout.png"
                alt="logout-photo"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
          </div>
          <div v-else>
            <router-link
              v-bind:to="{ name: 'home' }"
              data-toggle="tooltip"
              title="Home"
            >
              <img
                class="topImage"
                src="./assets/home.png"
                alt="home-link"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
            <router-link
              v-bind:to="{ name: 'login' }"
              data-toggle="tooltip"
              title="Login"
            >
              <img
                class="topImage"
                src="./assets/login.png"
                alt="login-photo"
                width="35"
                height="35"
              /> </router-link
            >&nbsp;&nbsp;
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