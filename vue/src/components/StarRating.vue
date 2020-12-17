<template>
  <div class="star-rate">
    <span
      :class="{ checked: rating > 0 || mouseOver > 0 }"
      @mouseover="mouseOver = 1"
      @mouseleave="mouseOver = 0"
      @click="AddEditRate(1)"
      ><font-awesome-icon :icon="['fas', 'star']"
    /></span>
    <span
      :class="{ checked: rating > 1 || mouseOver > 1 }"
      @mouseover="mouseOver = 2"
      @mouseleave="mouseOver = 0"
      @click="AddEditRate(2)"
      ><font-awesome-icon :icon="['fas', 'star']"
    /></span>
    <span
      :class="{ checked: rating > 2 || mouseOver > 2 }"
      @mouseover="mouseOver = 3"
      @mouseleave="mouseOver = 0"
      @click="AddEditRate(3)"
      ><font-awesome-icon :icon="['fas', 'star']"
    /></span>
    <span
      :class="{ checked: rating > 3 || mouseOver > 3 }"
      @mouseover="mouseOver = 4"
      @mouseleave="mouseOver = 0"
      @click="AddEditRate(4)"
      ><font-awesome-icon :icon="['fas', 'star']"
    /></span>
    <span
      :class="{ checked: rating > 4 || mouseOver > 4 }"
      @mouseover="mouseOver = 5"
      @mouseleave="mouseOver = 0"
      @click="AddEditRate(5)"
      ><font-awesome-icon :icon="['fas', 'star']"
    /></span>
    <p>{{ userRate ? `You rated ${rating}` : "Rate?" }}</p>
  </div>
</template>
<script>
import photoService from "@/services/PhotoService";

export default {
  props: ["ratings", "photo"],
  component: {
    photoService,
  },
  data() {
    return {
      userRate: null,
      rating: 0,
      mouseOver: 0,
    };
  },
  created() {
    if (this.ratings.length > 0) {
      this.findUserRate(this.ratings);
    }
  },
  methods: {
    findUserRate(ratings) {
      if (this.ratings.length > 0) {
        ratings.forEach((rt) => {
          if (rt.userId == this.$store.state.user.id) {
            this.userRate = rt;
            this.rating = this.userRate.rating;
          }
        });
      }
    },
    AddEditRate(rate) {
      if (this.userRate) {
        this.userRate.rating = rate;
        photoService
          .editRating(this.userRate)
          .then((res) => {
            if (res.status === 201) {
              this.$store.commit("EDIT_RATING", res.data);
              this.findUserRate(this.ratings);
            }
          })
          .catch((err) => {
            console.log(err);
          });
      } else {
        this.userRate = {
          pictureId: this.photo.pictureId,
          userId: this.$store.state.user.id,
          rating: rate,
        };

        photoService
          .addRating(this.userRate)
          .then((res) => {
            if (res.status === 201) {
              this.$store.commit("ADD_RATING", res.data);
              this.findUserRate(this.ratings);
            }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
};
</script>

<style >
.star-rate {
  font-size: 13pt;
}
div p {
  font-size: 7pt;
  color: black;
  font-style: italic;
  margin-bottom: 0px;
}
.checked {
  color: gold;
}
div span {
  color: rgb(196, 193, 193);
}
div span:hover {
  -webkit-filter: drop-shadow(5px 5px 5px rgba(34, 34, 34, 0.904));
  filter: drop-shadow(5px 5px 5px rgba(34, 34, 34, 0.904));
  color: gold;
}
.star-rate {
  position: absolute;
  left: 10px;
}
</style>