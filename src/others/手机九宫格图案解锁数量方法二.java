package others;

public class 手机九宫格图案解锁数量方法二 {
	
	public static void main(String[] args) {
		int count=0;
		for(int i1=1; i1<10; i1++){
			for(int i2=1; i2<10; i2++){
				if(i2 == i1) continue;
				if((i2+i1)%2 ==0 ){
					int mid=(i1+i2)/2;
					if(mid == 2 || mid== 8 || mid == 5) continue;
					if(mid == 4 && (i2 == 1 || i2 == 7)) continue;
					if(mid == 6 && (i2 == 3 || i2 == 9)) continue;
				}

				for(int i3=1; i3<10; i3++){
					if(i3 == i1 || i3 == i2) continue;
					if((i2+i3)%2 ==0 ){
						int mid=(i3+i2)/2;
						if((mid == 2 || mid== 8 || mid == 5) && mid != i1) continue;
						if(mid == 4 && i1 != 4 && (i3 == 1 || i3 == 7)) continue;
						if(mid == 6 && i1 != 6 && (i3 == 3 || i3 == 9)) continue;
					}


					for(int i4=1; i4<10; i4++){
						if(i4 == i1 || i4 == i2 || i4 == i3) continue;
						if((i3+i4)%2 ==0 ){
							int mid=(i3+i4)/2;
							if((mid == 2 || mid== 8 || mid == 5) && mid != i1 && mid != i2) continue;
							if(mid == 4 && i1 != 4 && i2!=4 && (i4 == 1 || i4 == 7)) continue;
							if(mid == 6 && i1 != 6 && i2!=6 && (i4 == 3 || i4 == 9)) continue;
						}

						for(int i5=0; i5<10; i5++){
							if(i5 == i1 || i5 == i2 || i5 == i3 || i5 == i4 ) continue;
							if( i5!= 0 && (i4+i5)%2 ==0 ){
								int mid=(i4+i5)/2;
								if((mid == 2 || mid== 8 || mid == 5) && mid != i1 && mid != i2 && mid != i3) continue;
								if(mid == 4 && i1 != 4 && i2!=4 && i3!=4 && (i5 == 1 || i5 == 7)) continue;
								if(mid == 6 && i1 != 6 && i2!=6 && i3!=6 && (i5 == 3 || i5 == 9)) continue;
							}

							if(i5 == 0){
								System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4);
								count++;
							}else{

								for(int i6=0; i6<10; i6++){
									if( i6 == i1 || i6 == i2 || i6 == i3 || i6 == i4 || i6 == i5) continue;
									if( i6 != 0 && (i5+i6)%2 ==0 ){
										int mid=(i5+i6)/2;
										if((mid == 2 || mid== 8 || mid == 5) && mid != i1 && mid != i2 && mid != i3 && mid !=i4) continue;
										if(mid == 4 && i1 != 4 && i2!=4 && i3!=4 && i4!=4 && (i6 == 1 || i6 == 7)) continue;
										if(mid == 6 && i1 != 6 && i2!=6 && i3!=6 && i4!=6 && (i6 == 3 || i6 == 9)) continue;
									}

									if(i6 == 0){
										System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4+"	"+i5);
										count++;
									}else{

										for(int i7=0; i7<10; i7++){
											if(i7 == i1 || i7 == i2 || i7 == i3 || i7 == i4 || i7 == i5 || i7 == i6) continue;
											if(i7!=0 && (i6+i7)%2 ==0 ){
												int mid=(i6+i7)/2;
												if((mid == 2 || mid== 8 || mid == 5) && mid != i1 && mid != i2 && mid != i3 && mid !=i4 && mid !=i5) continue;
												if(mid == 4 && i1 != 4 && i2!=4 && i3!=4 && i4!=4 && i5!=4 && (i7 == 1 || i7 == 7)) continue;
												if(mid == 6 && i1 != 6 && i2!=6 && i3!=6 && i4!=6 && i5!=6 && (i7 == 3 || i7 == 9)) continue;
											}

											if(i7 == 0){
												System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4+"	"+i5+"	"+i6);
												count++;
											}else{


												for(int i8=0; i8<10; i8++){
													if(i8 == i1 || i8 == i2 || i8 == i3 || i8 == i4 || i8 == i5 || i8 == i6 || i8==i7) continue;
													if(i8!= 0 && (i7+i8)%2 ==0 ){
														int mid=(i7+i8)/2;
														if((mid == 2 || mid== 8 || mid == 5) && mid != i1 && mid != i2 && mid != i3 && mid !=i4 && mid !=i5 && mid!=i6 ) continue;
														if(mid == 4 && i1 != 4 && i2!=4 && i3!=4 && i4!=4 && i5!=4 && i6!= 4 && (i8 == 1 || i8 == 7)) continue;
														if(mid == 6 && i1 != 6 && i2!=6 && i3!=6 && i4!=6 && i5!=6 && i6!= 6 && (i8 == 3 || i8 == 9)) continue;
													}

													if(i8 == 0){
														System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4+"	"+i5+"	"+i6+"	"+i7);
														count++;
													}else{


														for(int i9=0; i9<10; i9++){
															if(i9 == i1 || i9 == i2 || i9 == i3 || i9 == i4 || i9 == i5 || i9 == i6 || i9==i7 || i9 == i8 ) continue;
															if(i9 == 0){
																System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4+"	"+i5+"	"+i6+"	"+i7+"	"+i8);
																count++;
															}else{
																System.out.println(count+1+"	"+i1+"	"+i2+"	"+i3+"	"+i4+"	"+i5+"	"+i6+"	"+i7+"	"+i8+"	"+i9);
																count++;
															}

														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		
	}

}
