import React from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      showBooks: true,
      showBlogs: true,
      showCourses: true
    };
  }

  render() {
    return (
      <div>
        <h1>Blogger App</h1>

        <button onClick={() => this.setState({ showBooks: !this.state.showBooks })}>
          Toggle Books
        </button>
        <button onClick={() => this.setState({ showBlogs: !this.state.showBlogs })}>
          Toggle Blogs
        </button>
        <button onClick={() => this.setState({ showCourses: !this.state.showCourses })}>
          Toggle Courses
        </button>

        <BookDetails show={this.state.showBooks} />
        <BlogDetails show={this.state.showBlogs} />
        <CourseDetails show={this.state.showCourses} />
      </div>
    );
  }
}

export default App;
