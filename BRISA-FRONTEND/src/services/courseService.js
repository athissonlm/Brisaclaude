import api from './api';

export const courseService = {
  async getAll() {
    try {
      const response = await api.get('/courses');
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async getById(id) {
    try {
      const response = await api.get(`/courses/${id}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async getProgressionsByClassId(classId) {
    try {
      const response = await api.get(`/courses/progressions/class/${classId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};