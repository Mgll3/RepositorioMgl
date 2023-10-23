import React, { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import '../styles/CarouselComponent.css';

function CarouselComponent() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <div className="carousel-container">
      <Carousel>
        <Carousel.Item interval={5000} >
          <img src="https://media.geeksforgeeks.org/wp-content/uploads/20210425122739/2-300x115.png" alt="Promo Image 1"/>
          <Carousel.Caption>
            <h3>Carousel</h3>
            <p>Promo1</p>
          </Carousel.Caption>
          <img src="https://media.geeksforgeeks.org/wp-content/uploads/20210425122716/1-300x115.png" alt="Promo Image 2"/>
        </Carousel.Item>
        <Carousel.Item interval={5000}>
          <img src="https://media.geeksforgeeks.org/wp-content/uploads/20210425122739/2-300x115.png" alt="Promo Image 3"/>
          <Carousel.Caption>
            <h3>Carousel</h3>
            <p>Promo2</p>
          </Carousel.Caption>
          <img src="https://media.geeksforgeeks.org/wp-content/uploads/20210425122716/1-300x115.png" alt="Promo Image 4"/>
        </Carousel.Item>
      </Carousel>
    </div>
  );
}

export default CarouselComponent;
