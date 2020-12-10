<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'profile' }">Profile</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'favorites' }">Favorites</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>

</style>
