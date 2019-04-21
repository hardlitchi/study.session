<template>
  <div class="board">
    <h1>{{ name }}</h1>
    <ul>
      <li> test : testcon</li>
      <EventChild v-for="task in tasks"
        v-bind:key="task.id"
        v-bind:id="task.id"
        v-bind:name="task.name"></EventChild>
    </ul>
  </div>
</template>

<script>
import EventChild from '@/components/EventChild'

export default {
  name: 'ProjectBoard',
  data () {
    return {
      name: 'Your project name.',
      tasks: [
        {id: 1, name: '春のパン祭り'},
        {id: 2, name: '穴滝'},
        {id: 3, name: 'ストリートスナップ'}
      ]
    }
  },
  components: {
    EventChild
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
