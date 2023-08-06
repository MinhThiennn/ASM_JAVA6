var swiperwish = new Swiper('.product_1 .swiper-container', {
		slidesPerView: 4,
		//centeredSlides: true,
		loop: false,
		grabCursor: true,
		spaceBetween: 20,
		roundLengths: true,
		slideToClickedSlide: false,
		navigation: {
			nextEl: '.product_1 .swiper-button-next',
			prevEl: '.product_1 .swiper-button-prev',
		},
		autoplay: false,
		breakpoints: {
			300: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			500: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			640: {
				slidesPerView: 3,
				spaceBetween: 10
			},
			768: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			991: {
				slidesPerView: 3,
				spaceBetween: 20
			},
			1200: {
				slidesPerView: 4,
				spaceBetween: 20
			}
		}
	});

	
	var swiperwish = new Swiper('.product_2 .swiper-container', {
		slidesPerView: 4,
		//centeredSlides: true,
		loop: false,
		grabCursor: true,
		spaceBetween: 20,
		roundLengths: true,
		slideToClickedSlide: false,
		navigation: {
			nextEl: '.product_2 .swiper-button-next',
			prevEl: '.product_2 .swiper-button-prev',
		},
		autoplay: false,
		breakpoints: {
			300: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			500: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			640: {
				slidesPerView: 3,
				spaceBetween: 10
			},
			768: {
				slidesPerView: 2,
				spaceBetween: 10
			},
			991: {
				slidesPerView: 3,
				spaceBetween: 20
			},
			1200: {
				slidesPerView: 4,
				spaceBetween: 20
			}
		}
	});



	var swiper = new Swiper('.swiper', {
		slidesPerView: 3,
		direction: getDirection(),
		navigation: {
		  nextEl: '.swiper-button-next',
		  prevEl: '.swiper-button-prev',
		},
		on: {
		  resize: function () {
			swiper.changeDirection(getDirection());
		  },
		},
	  });
  
	  function getDirection() {
		var windowWidth = window.innerWidth;
		var direction = window.innerWidth <= 760 ? 'vertical' : 'horizontal';
  
		return direction;
	  }