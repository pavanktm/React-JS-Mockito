class App extends React.Component {
  state={
    name:'',
    enteredName: false
  };
  handleChangeName=function(event){
    this.setState({name: event.target.value, enteredName: true});
  }
  clearContent = function(event){
    console.log("clearing name");
    this.setState({name: "", enteredName: false});
  }
  render() {
    return( <div>
        {!this.state.enteredName ? 
          <p>Enter Your Name Please!</p>: 
          <p>Hello {this.state.name}</p>}
        <input type="text" value={this.state.name} 
          onChange={this.handleChangeName.bind(this)}/>
        <button onClick={this.clearContent.bind(this)}>Clear</button>
      </div>)
  }
}

ReactDOM.render(<App />, document.getElementById('app'));