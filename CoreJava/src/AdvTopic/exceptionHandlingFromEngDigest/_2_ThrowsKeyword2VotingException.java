package AdvTopic.exceptionHandlingFromEngDigest;

// TODO: throw -
// ref: https://www.youtube.com/watch?v=vldtYXFmZSc&list=PLlhM4lkb2sEjaU-JAASDG4Tdwpf-JFARN&index=11
class YoungerAgeException extends RuntimeException{

    public YoungerAgeException(String exceptionMsg){
        // for formatted string printing
       // super(String.format("%s not found with %s : %d", resourceName, fieldName, fieldValue)); //Ex:  Post not found with id : 1
        super(exceptionMsg); // this will pass to the default exception handler.
    }
}


public class _2_ThrowsKeyword2VotingException {
        public static void main(String[] args) {
//        int age = 10;
//        if (age<18){
//            throw new YoungerAgeException("You are not eligible for vote.");
//        }else{
//                System.out.println("You are eligible for VOTE.");
//            }
//        System.out.println("Successfully handled Exception!!");

        /*
        OUTPUT:
        Exception in thread "main" AdvTopic.exceptionHandlingFromEngDigest.YoungerAgeException: You are not eligible for vote.
	at AdvTopic.exceptionHandlingFromEngDigest._2_ThrowsKeyword2VotingException.main(_2_ThrowsKeyword2VotingException.java:18)

        means program stopped abnormally when got Exception i.e. without executing -         System.out.println("Successfully handled Exception!!");
        so we need to handle it as well if we want with try-catch.
         */


            int age = 10;
            try {
                if (age<18){
                    throw new YoungerAgeException("You are not eligible for vote.");
                }else{
                    System.out.println("You are eligible for VOTE.");
                }
            } catch (YoungerAgeException e){
                e.printStackTrace();
            }
            System.out.println("Successfully handled Exception!!");

            /*
            OUTPUT:
            AdvTopic.exceptionHandlingFromEngDigest.YoungerAgeException: You are not eligible for vote.
	        at AdvTopic.exceptionHandlingFromEngDigest._2_ThrowsKeyword2VotingException.main(_2_ThrowsKeyword2VotingException.java:37)
            Successfully handled Exception!!
             */

        }


}
