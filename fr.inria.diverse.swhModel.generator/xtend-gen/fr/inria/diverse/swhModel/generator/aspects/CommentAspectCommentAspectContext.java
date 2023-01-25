package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Comment;

@SuppressWarnings("all")
public class CommentAspectCommentAspectContext {
  public static final CommentAspectCommentAspectContext INSTANCE = new CommentAspectCommentAspectContext();
  
  public static CommentAspectCommentAspectProperties getSelf(final Comment _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CommentAspectCommentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Comment, CommentAspectCommentAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Comment, fr.inria.diverse.swhModel.generator.aspects.CommentAspectCommentAspectProperties>();
  
  public Map<Comment, CommentAspectCommentAspectProperties> getMap() {
    return map;
  }
}
