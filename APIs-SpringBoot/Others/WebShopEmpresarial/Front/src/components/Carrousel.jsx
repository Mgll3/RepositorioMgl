import React, { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import '../styles/CarouselComponent.css';
import publicidad1 from "../images/1.png";
import publicidad2 from "../images/2.png";
import publicidad3 from "../images/3.png";
import publicidad4 from "../images/4.png";

function CarouselComponent() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <div className="carousel-container debug" >
      <Carousel activeIndex={index} onSelect={handleSelect}>
        <Carousel.Item interval={5000}>
          <img src={publicidad1} alt="Promo Image 1" />
          <Carousel.Caption>

            <p>60000$</p>
          </Carousel.Caption>
        </Carousel.Item>
        
        <Carousel.Item interval={5000}>
          <img src={publicidad2} alt="Promo Image 2" />
          <Carousel.Caption>
          <h3>PARLANTE TYG TG:165C</h3>
            <p>90000$</p>
           
          </Carousel.Caption>
        </Carousel.Item>
        
        <Carousel.Item interval={5000}>
          <img src={publicidad3} alt="Promo Image 3" />
          <Carousel.Caption>
          <h3>Diademas Mark Boss</h3>
            <p>110000$</p>
          </Carousel.Caption>
        </Carousel.Item>

        <Carousel.Item interval={5000}>
          <img src={publicidad4} alt="Promo Image 4" />
          <Carousel.Caption>
            <h3>TV BOX</h3>
            <p>20000$</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </div>
  );
}

export default CarouselComponent;
