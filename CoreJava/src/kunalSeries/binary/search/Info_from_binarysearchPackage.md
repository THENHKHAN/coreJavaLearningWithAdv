Binary search integer limit exceeding resolve: 
`int middleIndex = (s+e)/2; start_end ==> might exceed the integer limit that's y we got a new way to do the same
 int middleIndex = s + (e-s)/2; //  (s+e +s-s)/2 => (2s+e-s)/2 => 2s/2 + (e-s)/2 => s + (e-s)/2 now this won't exceed integer range`