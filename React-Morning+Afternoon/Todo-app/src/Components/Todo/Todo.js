import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { todo: "first todo", marked: false, delete: false },
      { todo: "2nd todo", marked: true, delete: false },
    ],
    title: "My tasks",
    filterBy: "Show all",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });
      this.setState({ todos: newTodos, todo: "" });
    }
  };

  markTaskAsCompleted = (event, index) => {
    const { todos } = this.state;

    const newTodos = [...todos];

    newTodos[index] = {
      ...newTodos[index],
      marked: event.target.checked,
    };

    this.setState({ todos: newTodos });
  };

  //function to change the filterBy state
  changeFilter = (selectedFilter)=>{
    
    this.setState({filterBy:selectedFilter});
  }

  //function to delete a todo
  deleteTodo = (index)=>{
    const { todos } = this.state;
    const deletedTodo = todos[index];

    const newTodos = todos.filter(
      todo => todo!==deletedTodo
    )
    
    this.setState({ todos: newTodos, todo: "" });
  }

  //function to duplicate a todo
  duplicateTodo = (todo)=>{
    const { todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });
      this.setState({ todos: newTodos, todo: "" });
    }
  }

  render() {
    return (
      <div className="TodoContainer">
        <h1 className="Header Header-Main">{this.props.title}</h1>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleOnChange}
        />
        <button onClick={this.addTask}>Add Task</button>
        <button onClick={()=>{this.changeFilter("Show all")}}>Show all</button>
        <button onClick={()=>{this.changeFilter("Completed")}}>Completed</button>
        <button onClick={()=>{this.changeFilter("Pending")}}>Pending</button>
        <Todolist
          title={this.state.title}
          todos={this.state.todos}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
          deleteTodo={this.deleteTodo}
          duplicateTodo={this.duplicateTodo}
        />
      </div>
    );
  }
}

export default Todo;
