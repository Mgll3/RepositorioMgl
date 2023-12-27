import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Banner from '../components/Banner';
import SearchBox from '../components/SearchBox';
import PromoSection from '../components/PromoSection';
import Carrousel from '../components/Carrousel';
import Carrito from '../components/Carrito';
import Itemtext from '../components/ItemsText';
import Logo from '../components/Logo';
import BotonWhatsap from '../components/BotonWhatsap';
import ProductDetail from './ProductDetail';
import '../styles/App.css';

const App = () => {
  return (
    <Router>
      <div className="App">
        <div className="ItemLocation">
          <Banner>
            <Itemtext />

            <div className='Logosearch'><Logo />
              <SearchBox /></div>
            <Carrito />

            {/*<BotonWhatsap />*/}
          </Banner>
          <Routes>
            <Route
              path="producto/:id"
              element={<ProductDetail />}
            />
            <Route
              path="carrousel"
              element={<Carrousel />}
            />
            <Route
              path=""
              element={
                <>
                  <Carrousel />
                  <PromoSection />

                </>
              }
            />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
