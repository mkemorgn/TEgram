<template>
  <div id="app">
    <div id="nav">
      <a class="logo-link" href="http://localhost:8081/">
      <img src="./assets/TE_Mark_Website2020_v3-01.png" id="logo" alt="Logo">
      </a>
      <div class="nav-links">
        <router-link v-bind:to="{ name: 'home' }">
          <img class="topImage" src="./assets/home.png" alt="home-link" width="35" height="35" />
          </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'profile' }">
          <img class="topImage" src="./assets/account.png" alt="user profile" width="35" height="35" />
          </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'favorites' }">
          <img class="topImage" src="./assets/heart.png" alt="favorite photos link" width="35" height="35" />
          </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'upload' }">
          <img class="topImage" src="./assets/upload-img.png" alt="upload-photo" width="35" height="35"/>
          </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
          <img class="topImage" src="./assets/logout.png" alt="logout-photo" width="35" height="35"/>
          </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>
          <img class="topImage" src="./assets/logout.png" alt="logout-photo" width="35" height="35"/>
        </router-link>
      </div>
    </div>

    <router-view />
  </div>
</template>

<style>
@import "../style/style.css";
</style>