<template>
<div class="rating">
    <div class="card-text">
        
    {{ r.byUser }}: {{ r.r }}
            
    </div>
</div>
</template>

<script>
export default {
    props: [
    "r",
  ],
}
</script>