<template>
<div class="comments">
    <div class="card-text" id=":commentbox">
        <b-table-simple responsive outlined>
            <b-thead>
            <b-tr>
                <b-th>{{ comment.byUser }}: {{ comment.comment }}</b-th>
            </b-tr>
            </b-thead>
        </b-table-simple>
    </div>
    <br />
    
</div>
</template>

<script>
export default {
    props: [
    "comment",
  ],
}
</script>