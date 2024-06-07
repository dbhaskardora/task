import './App.css';
import Nav from './Components/Nav';
import Login from './Components/Login';
import Footer from './Components/Footer';

function App() {
  return (
    <div className="App">
      <Nav/>
      <div className="content">
        <Login/>
      </div>
      <div className="foot">
      <Footer/>
      </div>
    </div>
   
  );
}

export default App;
