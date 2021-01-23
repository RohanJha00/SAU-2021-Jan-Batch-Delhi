import React from "react";
import PropTypes from "prop-types";

class Todolist extends React.Component {
  static propTypes = {
    todos: PropTypes.arrayOf(
      PropTypes.shape({
        todo: PropTypes.string,
        marked: PropTypes.bool,
      })
    ),
  };

  render() {
    const { todos,filterBy, markTaskAsCompleted,deleteTodo,duplicateTodo } = this.props;

    return (
      <div>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {todos
            ? todos.map((value, index) => {
              if(filterBy==="Show all" || filterBy==="Pending"&&!value.marked || filterBy==="Completed"&&value.marked)
               { return (
                  <li key={index} className="TaskRow">
                    
                    <label
                      style={
                        value.marked
                          ? {
                              textDecoration: "line-through",
                            }
                          : {}
                      }
                      className={value.marked ? "checked" : ""}
                    >
                      <input
                        type="checkbox"
                        checked={value.marked}
                        onChange={(event) => markTaskAsCompleted(event, index)}
                      />
                      {value.todo}
                    </label>
                    <button className="hidden" onClick={()=>deleteTodo(index)}>Delete</button>
                    <button className="hidden" onClick={()=>{duplicateTodo(value.todo)}}>Duplicate</button>
                  </li>
                );
                    }
                    else{
                      return (
                        <li key={index}></li>
                      );
                    }
              
              })
            : null}
        </ul>
      </div>
    );
  }
}

// const Todolist = (props) => {
//     const { todos, title } = props;

//     return (
//       <div>
//         <h3>{title}</h3>
//         <ul>
//           {todos
//             ? todos.map((todo, index) => {
//                 return <li>{todo}</li>;
//               })
//             : null}
//         </ul>
//       </div>
//     );
// }

export default Todolist;
