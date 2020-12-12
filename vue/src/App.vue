<template>
  <div id="app">
    <div id="nav">
      <a href="http://localhost:8081/">
        <img
          src="./assets/TE_Mark_Website2020_v3-01.png"
          id="logo"
          alt="Logo"
        />
      </a>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'profile' }">Profile</router-link
      >&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'favorites' }">Favorites</router-link
      >&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'upload' }">Upload Photo</router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </div>

    <router-view />
  </div>
</template>

<style>
@import "../style/style.css";
</style>