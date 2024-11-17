
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Authentication from './pages/Authentication/Authentication';
import HomePage from './pages/Homepage/HomePage';
import { Message } from '@mui/icons-material';
import { useDispatch, useSelector } from 'react-redux';
import { getProfileAction,  } from './Redux/Auth/auth.action';
import { useEffect } from 'react';
import { store } from './Redux/store';

function App() {
  const {auth} = useSelector(store=>store)
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  useEffect(() => {
    dispatch(getProfileAction(jwt));
  }, [jwt]);


  return (
    <div className="App">
      
      <Routes>
          <Route path="/*" element={auth.user?<HomePage />:<Authentication/>} />
          <Route path="/*" element={<Authentication />} />
        </Routes>
        
    </div>
  );
}

export default App;
