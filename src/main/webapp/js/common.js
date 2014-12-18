// JavaScript Document
var M = {};

M.asideNav = (function(M){
		var leftNav,
			_fnToggle = function(){
				var self = $(this),
					subDiv = self.next();
				_fnReset(self,subDiv);
				self.toggleClass('active');
				subDiv.slideToggle(200);
			},
			_fnReset = function(aEle,divEle){
				leftNav.find('.active').not(aEle).removeClass('active');
				leftNav.find('.sub-nav:visible').not(divEle).slideUp(100);
			},
			init = function(){
				leftNav = $('#leftNav');
				leftNav.on('click','.has-sub .tit',_fnToggle);
			};
		return{
			init : init	
		}
	})(M);
