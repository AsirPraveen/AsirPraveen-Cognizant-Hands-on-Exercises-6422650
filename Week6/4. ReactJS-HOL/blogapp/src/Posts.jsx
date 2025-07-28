// src/Posts.jsx
import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // Load posts using fetch
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error:', error);
        alert('Error loading posts');
      });
  }

  // componentDidMount
  componentDidMount() {
    this.loadPosts();
  }

  // Error Boundary
  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
    console.error("Error info:", info);
  }

  // Render method
  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
