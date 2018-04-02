package de.conio.web.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.conio.core.structure.PostComment;

public class PostHelper {

	public static List<PostComment> toThreadedComments(Set<PostComment> comments){

        //comments should be sorted by date first
        
        //The resulting array of threaded comments
        List<PostComment> threaded = new ArrayList<PostComment>();
        
        //An array used to hold processed comments which should be removed at the end of the cycle
        List<PostComment> removeComments = new ArrayList<PostComment>();

        //get the root comments first (comments with no parent)
        for (PostComment comment : comments) {
             if(comment.getParentId() == 0){
                 comment.setCommentDepth(0); //A property of Comment to hold its depth
                 comment.setChildCount(0); //A property of Comment to hold its child count
                 threaded.add(comment);
                 removeComments.add(comment);
             }
        }

        if(removeComments.size() > 0){
            //clear processed comments
            comments.removeAll(removeComments);
            removeComments.clear();
        }

        int depth = 0;
        //get the child comments up to a max depth of 10
        while(comments.size() > 0 && depth <= 10){
            depth++;
            for(PostComment child : comments){
                //check root comments for match
                for(int i = 0; i < threaded.size(); i++){
                    PostComment parent = threaded.get(i);
                    if(parent.getId() == child.getParentId()){
                        parent.setChildCount(parent.getChildCount()+1);
                        child.setCommentDepth(depth+parent.getCommentDepth());
                        threaded.add(i+parent.getChildCount(),child);
                        removeComments.add(child);
                        continue;
                    }
                }
            }
            if(removeComments.size() > 0){
                //clear processed comments
                comments.removeAll(removeComments);
                removeComments.clear();
            }
        }

        return threaded;
    }
}
