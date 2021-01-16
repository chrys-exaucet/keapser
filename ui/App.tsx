import React from "react";
import "./App.css";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";

import CreateAccount from "./components/CreateAccount";

class App extends React.Component {
  render(){
  return (
    <Router>
      <div className="app">
        <Switch>
          <Route path="/create_account">
            <CreateAccount />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}
}

export default App;
