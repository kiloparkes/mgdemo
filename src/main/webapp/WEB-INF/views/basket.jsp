<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>My Basket </h2>

<div id="feedback">
	<div id="confirm">
		<div id="confirm-text">
			<span class="hucSprite s_confirmCheck check"></span>
			1 Item added to basket.
		</div>
	</div>
	<div id="feedback-details">
		<div id="items">
			<ul>
				<li class="item">
					<div>
						<a class="" title="Testing" href="#">
							<img src='<c:url value="/images/kira.jpg"/>' alt=""  width="85" height="85" border="0"/>
							<span class="item-title">${current_item.desc1}</span>
						</a>
					</div>
					<div class="item-stats">
						<div class="item-byline">${current_item.desc2}</div>
						<div class="price">$11.19</div>
					</div>
				</li>
			</ul>
		</div>
		<div id="cart">
			<div class="cBox primary subcart-box">
				<div class="cBoxInner">
					<div id="cart-stats">
						<div id="cart-subtotal">
							Order Subtotal:
							<span class="price">${basket.subTotal}</span>
						</div>
						<div id="cart-itemcount-text">
							<span id="cart-itemcount">${basket.amount}</span>
							items in your Cart
						</div>
					</div>
					<div id="next-steps">
						<a class="hucSprite s_editCart cart-button" href="#">
							<span>Edit your Basket</span>
						</a>
						<a class="hucSprite s_checkout checkout-button" href="#">
							<span>Proceed to Checkout</span>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>


<br/>