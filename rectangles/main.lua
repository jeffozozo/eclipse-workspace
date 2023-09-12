
r = 10

local newRectangle = display.newRect(math.random(320), math.random(480), 10 + math.random(100), 10+math.random(100))
	newRectangle:setFillColor( 0,200,0 )

for i = 1 , 20 do
	 r = r + 10
	 g = 1 + math.random(230)
	 b = 1 + math.random(230)

	newRectangle = display.newRect(	math.random(220), math.random(480), 10 + math.random(100), 10+math.random(100))
	newRectangle:setFillColor( math.random(220), r, b )


end



