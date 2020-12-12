<template>
  <div class="background">
    <div class="home">
      <div class="header">
        <!-- Logo -->
        <!-- <router-link v-bind:to="{ name: 'home' }">
          <img id="logo" src="../assets/TeGram-logo.png" alt="TE-Gram Logo" />
        </router-link> -->
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
                <img class="topImage" src="../assets/logout.png" alt="logout-photo" width="35" height="35"/>
              </router-link>
            </li>
          </ul>
        </nav>
        <!-- End nav --> 
        <photo-feed class="feed" />
      </div>
    </div>
  </div>
</template>


