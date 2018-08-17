class App extends React.Component {
  state={
    counter:0,
    fizzBuzz: ""
  };
  isFizzBuzz=function(){
    console.log('value: '+ value);
    let value = this.state.counter, display = this.state.fizzBuzz;
    if(value%3==0){
      display += "fizz,"
    } else if(value%5==0){
      display += "buzz,"
    } else{
      display += value + ","
    }
    this.setState({fizzBuzz: display});
  }
  handleIncrement=function(event){
    this.setState({counter: ++this.state.counter});
    this.isFizzBuzz();
  }
  handleDecrement = function(event){
    this.setState({counter: --this.state.counter});
    this.isFizzBuzz();
  }
  render() {
    return( <div>
        <p>Welcome to Fizz-Buzz App!</p>
        <button onClick={this.handleIncrement.bind(this)}>+</button>
        <button onClick={this.handleDecrement.bind(this)}>-</button>
        <br />
        <br />
        <label> Fizz Buzz Value is: {this.state.fizzBuzz}</label>
      </div>)
  }
}

ReactDOM.render(<App />, document.getElementById('app'));