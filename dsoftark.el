;; Emacs hacks for java development with ant.
;; I have no idea if this works for emacs on windows.
;;
;; Paste this file in your .emacs or use the following line:
;;   (load-file "path/to/this-file.el")
;;
;; After including the following key bindings will be available in java-mode
;;   C-c C-v -- run default ant target
;;   C-c C-t -- run ant test target
;;
;; Or you may invoke them as commands with
;;   M-x ant-compile RET
;;   M-x ant-test RET

(defun path-parent (path)
  (let ((new-path (mapconcat 'identity
                             (butlast (split-string path "/"))
                             "/")))
    (if (equal (substring path 0 1) "/")
        (concat "/" new-path)
        new-path)))

(defun find-ant-path (path)
  (cond ((or (equal "/" path) (equal "" path)) nil)
        ((file-exists-p (concat path "/build.xml")) path)
        (t (find-ant-path (path-parent path)))))

(defun ant-compile (&optional target)
  "Compile function that searches recursively backwards for an ant build.xml
   file. If no file is found invokes `compile' in the default manner."
  (interactive)
  (let ((ant-path (find-ant-path (path-parent (buffer-file-name)))))
    (if ant-path
	(let ((my-buf (current-buffer))
	      (com-buf (compile (concat "cd " ant-path " && ant -emacs " target))))
	  (switch-to-buffer-other-window com-buf)
	  (end-of-buffer)
	  (switch-to-buffer-other-window my-buf)
	  )
        ;; default to ordinary compile
        (call-interactively 'compile))))

(defun ant-test ()
  "Runs the ant test target and removes unwanted JUnit output."
  (interactive)
  (ant-compile "test | grep -v 'apache\\|reflect\\|org\\.junit'"))

;; add key bindings to java mode
(add-hook 'java-mode-hook
	  (lambda ()
	    ;; C-c C-v -- run default compile target
	    (local-set-key [(control c) (control v)] 'ant-compile)
	    ;; C-c C-t -- run test target
	    (local-set-key [(control c) (control t)] 'ant-test)))
