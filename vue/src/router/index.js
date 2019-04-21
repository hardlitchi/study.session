import Vue from 'vue'
import Router from 'vue-router'
import ProjectBoard from '@/components/ProjectBoard'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ProjectBoard',
      component: ProjectBoard
    }
  ]
})
